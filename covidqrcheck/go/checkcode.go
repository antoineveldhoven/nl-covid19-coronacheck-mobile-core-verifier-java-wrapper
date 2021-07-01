package main

import "C"

import (
	"encoding/json"
	mobilecore "github.com/minvws/nl-covid19-coronacheck-mobile-core"
)

//export CheckCode
func CheckCode(code []byte) *C.char {
	mobilecore.InitializeVerifier("./config")

	verifiedCred := mobilecore.Verify(code)

	if verifiedCred.Error == "" {
		var verificationResult *mobilecore.VerificationResult
		json.Unmarshal(verifiedCred.Value, &verificationResult)
		return C.CString(`{"success": true,
                        "data": {
                                "CredentialVersion": "` + verificationResult.CredentialVersion + `",
                                "IsSpecimen": "` + verificationResult.IsSpecimen + `",
                                "FirstNameInitial": "` + verificationResult.FirstNameInitial + `",
                                "LastNameInitial": "` + verificationResult.LastNameInitial + `",
                                "BirthDay": "` + verificationResult.BirthDay + `",
                                "BirthMonth": "` + verificationResult.BirthMonth + `",
                                "IsNLDCC": "` + verificationResult.IsNLDCC + `"
                        }
                }`)
	} else {
		return C.CString(`{"success": false, "error": "` + verifiedCred.Error + `"}`)
	}
}

func main() {}
