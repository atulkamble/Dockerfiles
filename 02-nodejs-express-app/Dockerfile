# =============================================================
# Node.js Express Application
# Base image: node:22-alpine (LTS, minimal Alpine footprint)
# =============================================================
FROM node:22-alpine

# ── Step 1: Set the working directory inside the container ──
WORKDIR /app

# ── Step 2: Copy package files first to leverage Docker layer caching ──
#    Dependencies are reinstalled only when package*.json changes
COPY package*.json ./

# ── Step 3: Install only production dependencies ──
RUN npm ci --omit=dev

# ── Step 4: Copy the rest of the application source code ──
COPY . .

# ── Step 5: Expose the port Express listens on ──
EXPOSE 3000

# ── Step 6: Start the application ──
CMD ["node", "app.js"]
