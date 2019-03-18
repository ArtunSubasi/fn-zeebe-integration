package main

import (
	"context"
	"encoding/json"
	"fmt"
	"io"

	fdk "github.com/fnproject/fdk-go"
)

func main() {
	fdk.Handle(fdk.HandlerFunc(myHandler))
}

type Customer struct {
	Email string `json:"email"`
}

func myHandler(ctx context.Context, in io.Reader, out io.Writer) {
	customer := &Customer{}
	json.NewDecoder(in).Decode(customer)
	if len(customer.Email) > 0 {
		fmt.Println("Sent email:", customer.Email)
	} else {
		fdk.WriteStatus(out, 400)
		io.WriteString(out, `{"error": "E-Mail not set"}`)
	}
	
}
