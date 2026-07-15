# =============================================================
# Go HTTP Server — Multi-Stage Build
# Stage 1 (builder): compiles the binary using the full Go SDK
# Stage 2 (runtime): copies only the binary into a minimal Alpine image
# =============================================================

# ── Stage 1: Build ──
FROM golang:1.23-alpine AS builder

WORKDIR /app

# Step 1: Copy module manifest and download dependencies
COPY go.mod ./
RUN go mod download

# Step 2: Copy source code and compile a statically-linked binary
COPY . .
RUN CGO_ENABLED=0 GOOS=linux go build -ldflags="-s -w" -o server .

# ── Stage 2: Runtime ──
# alpine:3.20 — tiny base image; only the compiled binary is copied
FROM alpine:3.20

WORKDIR /app

# Step 3: Copy the compiled binary from the builder stage
COPY --from=builder /app/server .

# Step 4: Expose the port the server listens on
EXPOSE 8080

# Step 5: Run the binary directly
CMD ["./server"]
