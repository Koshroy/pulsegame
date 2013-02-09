$(document).ready(readyFunc);

var QueryString = function () {
  // This function is anonymous, is executed immediately and 
  // the return value is assigned to QueryString!
  var query_string = {};
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
        // If first entry with this name
    if (typeof query_string[pair[0]] === "undefined") {
      query_string[pair[0]] = pair[1];
        // If second entry with this name
    } else if (typeof query_string[pair[0]] === "string") {
      var arr = [ query_string[pair[0]], pair[1] ];
      query_string[pair[0]] = arr;
        // If third or later entry with this name
    } else {
      query_string[pair[0]].push(pair[1]);
    }
  } 
    return query_string;
} ();

function readyFunc() {
    var c = document.getElementById('summonersRift');
    var a = new Animation('img_main.png', c.getContext('2d'))

    $("#summonersRift").keydown(function(e) { handleArrowKeys(e, a) });
    $("#prevBut").click(function () { a.renderPrevFrame() })
    $("#nextBut").click(function () { a.renderNextFrame() })
    
    $.get("/logs/game-" + QueryString["id"] + ".json", function(content){
	a.loadContent(content);
	if (content[0].Map.length > 0) {
	    c.height = 32*content[0].Map.length;
	    c.width = 32*content[0].Map[0].length;
	}
	a.render();
    });
}

function handleArrowKeys(event, anim) {
    switch(event.keyCode) {
    case 39:
	// right
	anim.renderNextFrame();
	break;
    case 37:
	// left
	anim.renderPrevFrame();
	break;
    }
    return;
}

function isTile(str) {
    return str.split(".")[0] == "TileType"
}

function SpriteSheet(sheetName, canvas) {
    this.tileImg = new Image();
    this.tileImg.src = sheetName;
    this.canvas = canvas;
}

SpriteSheet.prototype.drawTile = function(dx, dy, type) {
    this.canvas.drawImage(this.tileImg, 32*type, 0, 32, 32, dx, dy, 32, 32);
}

SpriteSheet.prototype.drawUnit = function(dx, dy, type) {
    this.canvas.drawImage(this.tileImg, 32*type + 96, 0, 32, 32, dx, dy, 32, 32);
}

function Animation(sheetName, canvas) {
    this.sheet = new SpriteSheet('img_main.png', canvas);

    this.frameNum = 0;
    this.maxFrame = 0;
    this.content = null;

    this.tileDict = {'TileType.PLAINS' : 0, 'TileType.HILL' : 1, 'TileType.OCEAN' : 2};
    this.unitDict = {'UnitType.TYPE0' : 1, '"UnitType.TYPE1"' : 0, "UnitType.TYPE2" : 2}
    
}

Animation.prototype.loadContent = function(content) {
    this.content = content;
    this.maxFrame = content.length;

    this.h = 0;
    this.w = 0;

    if (this.maxFrame > 0) {
	this.h = content[0].Map.length
	if (this.h > 0) {
	    this.w = content[0].Map[0].length
	}
    }
}

Animation.prototype.renderFrame = function(frameNum) {
    if ((frameNum >= 0) && (frameNum < this.maxFrame)) {
        this.drawState(frameNum);
       this.drawCanvas(this.sheet, this.content[frameNum].Map);
    }
    this.drawBasesOnMap();
}

Animation.prototype.drawState = function(frameNum) {
    $("#frameNum").html(frameNum.toString());
    $("#p1Name").html(this.content[frameNum].State[0]["Player Name"])
    $("#p2Name").html(this.content[frameNum].State[0]["Player Name"])
    $("#p1Gold").html(this.content[frameNum].State[0]["Player Economy"].toString())
    $("#p2Gold").html(this.content[frameNum].State[1]["Player Economy"].toString())
    $("#p1Iops").html(this.content[frameNum].State[0]["Invalid Ops"].toString())
    $("#p2Iops").html(this.content[frameNum].State[1]["Invalid Ops"].toString())
    $("#p1Vops").html(this.content[frameNum].State[0]["Valid Ops"].toString())
    $("#p2Vops").html(this.content[frameNum].State[1]["Valid Ops"].toString())

}

Animation.prototype.render = function() {
    this.renderFrame(this.frameNum);
}

Animation.prototype.renderNextFrame = function() {

    this.renderFrame(++this.frameNum);
}

Animation.prototype.renderPrevFrame = function() {
    this.renderFrame(--this.frameNum);
}

Animation.prototype.drawBasesOnMap = function() {
    console.log(this)
    if ( (this.h > 0) && (this.w > 0)) {
	console.log('wat')
	this.sheet.drawTile(32*5, 32*5, 9);
	this.sheet.drawTile(32*(this.w - 5), 32*(this.h - 5) - 5, 10);
    }
}

Animation.prototype.drawCanvas = function(sheet, map) {
    for (var yimg=0; yimg<25; yimg++)
    {
        for(var ximg=0; ximg<25; ximg++)
        {
	    var thing = map[ximg][yimg];
	    var tileInfo = thing.split(",")


	    var tileType = tileInfo[0]
	    var playerNum = parseInt(tileInfo[1])

	    if (isTile(tileType)) {
		sheet.drawTile(yimg*32, ximg*32, this.tileDict[tileType]);
	    }

	    else {
		sheet.drawUnit(yimg*32, ximg*32, this.unitDict[tileType] + 3*playerNum);
	    }
        }
	
    }

}


