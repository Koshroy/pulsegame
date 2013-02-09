$:.push('gen-rb')
require 'thrift'
require 'game'

begin
	port = 9090
	name = ARGV[0] || "rb"
  transport = Thrift::FramedTransport.new(Thrift::Socket.new('localhost', port))
  protocol = Thrift::BinaryProtocol.new(transport)
  client = Game::Client.new(protocol)

  transport.open()

	client.setRemote("localhost", "9090")
	
	game = client.startGame(name)	
	puts game
	client.surrender(game.tok)

	transport.close()
rescue Thrift::Exception => tx
	print 'Thrift::Exception: ', tx.message, "\n"
end
