How to build

```
mvn clean package
```

How to Deploy

```
sls deploy --stage stage
```

Invoke the Method NOT Working, because I only support API gateway

```
sls invoke --stage stage -f article-post --data='{"title":"carl", "author":"carl", "content": "content"}'
{
    "statusCode": 200,
    "body": "{\"id\":\"101\",\"title\":\"carl\",\"content\":\"content\",\"author\":\"carl\"}",
    "headers": {
        "X-Powered-By": "AWS Lambda & Serverless",
        "Content-Type": "application/json"
    },
    "isBase64Encoded": false
}
```