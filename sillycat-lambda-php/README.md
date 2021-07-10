### How to Run

Dependencies

```
composer update
```

Run the Test from Local

```
./vendor/bin/bref local echo '{"name":"carl"}'
```

Deploy Command

```
serverless deploy --stage stage
```

Invoke Lambda from Command Line
```
serverless invoke --stage stage -f echo --data='{"name":"carl"}'
```

