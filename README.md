# nl-covid19-coronacheck-mobile-core-verifier-java-wrapper

## Introduction
This repository contains a wrapper for checking a COVID QR Code.

Based on the sample QR code found on [https://coronacheck.nl/nl/scanner.html](https://coronacheck.nl/nl/scanner.html):

![QR](https://coronacheck.nl/img/qr/demo_qr_gray.png)

## Getting started 
Build a shared library (in your flavor .dll / .so / .dylib) from the ./go dir.
```shell
go build -buildmode=c-shared -o libcovid.dylib checkcode.go
````

Get current config & public keys:

```shell
run get.sh inside ./config dir.
```

Run maven to build Java

```shell
mvn install
```

## Running the example
Inside ./dist run
```shell
java -jar CheckCode.jar
````

## Expected output:

```json
{"success": true,
        "data": {
                "CredentialVersion": "1",
                "IsSpecimen": "1",
                "FirstNameInitial": "B",
                "LastNameInitial": "B",
                "BirthDay": "5",
                "BirthMonth": "7",
                "IsNLDCC": ""
        }
}
```