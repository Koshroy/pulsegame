GEN_SRC := Game.cpp game_constants.cpp game_types.cpp
GEN_OBJ := $(patsubst %.cpp,%.o, $(GEN_SRC))

THRIFT_INCLUDE := /usr/local/include/thrift

INC := -I$(THRIFT_INCLUDE)

CXX := g++

.PHONY: all clean

all: client

%.o: %.cpp
	$(CXX) -Wall -g -DHAVE_INTTYPES_H -DHAVE_NETINET_IN_H $(INC) -c $< -o $@

#thrift/lib/libthrift.a
client: main.o Client.o $(GEN_OBJ) 
	$(CXX) -g $^ -o $@ -lthrift

clean:
	$(RM) *.o client
