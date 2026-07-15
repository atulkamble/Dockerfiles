package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
)

// rootHandler handles GET / and returns a plain-text greeting.
func rootHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Hello, Go on Docker!")
}

// healthHandler handles GET /health for container orchestrator probes.
func healthHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(map[string]string{"status": "ok"})
}

func main() {
	http.HandleFunc("/", rootHandler)
	http.HandleFunc("/health", healthHandler)

	log.Println("Server listening on :8080")
	log.Fatal(http.ListenAndServe(":8080", nil))
}
