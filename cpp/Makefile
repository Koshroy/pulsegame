GEN_SRC := Game.cpp game_constants.cpp game_types.cpp
GEN_OBJ := $(patsubst %.cpp,%.o, $(GEN_SRC))

THRIFT_INCLUDE := include

UNAME := $(shell uname)
ifeq ($(UNAME), Darwin)
	THRIFT_LIB := libthrift-osx.a
endif
ifeq ($(UNAME), Linux)
	THRIFT_LIB := libthrift-x64.a
endif


INC := -I$(THRIFT_INCLUDE)

CXX := g++

.PHONY: all clean

all: client

%.o: %.cpp
	$(CXX) -Wall -g -DHAVE_INTTYPES_H -DHAVE_NETINET_IN_H $(INC) -c $< -o $@

client: main.o Client.o $(GEN_OBJ)
	$(CXX) -g $^ -o $@ $(THRIFT_LIB)

clean:
	$(RM) *.o client
