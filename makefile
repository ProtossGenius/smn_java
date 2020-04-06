clean:
	rm -rf ./datas/proto/*
	rm -rf ./src/pb 
	cp $(GOPATH)/src/github.com/ProtossGenius/SureMoonNet/datas/proto/* ./datas/proto/

test: clean
	smn_itf2proto -i ./datas/itfs/ -o ./datas/proto
	smn_goitf2lang -lang=java -i=./datas/itfs -o=./src/
	smn_protocpl -i ./datas/proto -o ./src -lang java

import:
	smcfg -install programs/maven
	mvn -f pom.xml dependency:copy-dependencies
