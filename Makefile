default:
	thrift \
		--out src/main/java \
		--gen java \
		-r \
		src/main/java/main.thrift