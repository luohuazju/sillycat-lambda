.PHONY: build clean deploy

build:
	env GOOS=linux GOARCH=amd64 go build -ldflags="-s -w" -o bin/create todos/create.go todos/model.go
	env GOOS=linux GOARCH=amd64 go build -ldflags="-s -w" -o bin/delete todos/delete.go todos/model.go
	env GOOS=linux GOARCH=amd64 go build -ldflags="-s -w" -o bin/get todos/get.go todos/model.go
	env GOOS=linux GOARCH=amd64 go build -ldflags="-s -w" -o bin/list todos/list.go todos/model.go
	env GOOS=linux GOARCH=amd64 go build -ldflags="-s -w" -o bin/update todos/update.go todos/model.go

clean:
	rm -rf ./bin ./vendor Gopkg.lock

deploy: clean build
	sls deploy --verbose

format: 
	gofmt -w todos/create.go
	gofmt -w todos/delete.go
	gofmt -w todos/get.go
	gofmt -w todos/list.go
	gofmt -w todos/update.go