How to build

```
mvn clean package
```

How to Deploy

```
sls deploy --stage stage
```

Invoke and Verify

```
sls invoke --stage stage -f article-post --data '{ "body": "{\"title\":\"carl\", \"author\":\"carl\", \"content\": \"content\"}" }'
```

```
sls invoke --stage stage -f article-get --data '{"pathParameters": {"id":"1"}}'
```