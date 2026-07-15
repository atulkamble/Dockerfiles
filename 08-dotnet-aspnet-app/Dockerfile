# =============================================================
# .NET ASP.NET Core Application — Multi-Stage Build
# Base: mcr.microsoft.com/dotnet/sdk:9.0 (.NET 9, current release)
# Stage 1 (builder): restores packages and publishes the app
# Stage 2 (runtime): runs on a minimal ASP.NET Core runtime image
# =============================================================

# ── Stage 1: Build ──
FROM mcr.microsoft.com/dotnet/sdk:9.0 AS builder

WORKDIR /app

# Step 1: Copy project file and restore NuGet packages (cached layer)
COPY *.csproj ./
RUN dotnet restore

# Step 2: Copy source and publish a self-contained release build
COPY . .
RUN dotnet publish -c Release -o /app/publish --no-restore

# ── Stage 2: Runtime ──
# aspnet:9.0 — only the ASP.NET Core runtime, no SDK overhead
FROM mcr.microsoft.com/dotnet/aspnet:9.0

WORKDIR /app

# Step 3: Copy the published output from the builder stage
COPY --from=builder /app/publish .

# Step 4: Expose the port ASP.NET Core listens on
EXPOSE 8080

# Step 5: Launch the application
ENTRYPOINT ["dotnet", "app.dll"]
