# =============================================================
# Nginx Static Site
# Base image: nginx:1.27-alpine (latest stable, minimal footprint)
# =============================================================
FROM nginx:1.27-alpine

# ── Step 1: Remove the default Nginx placeholder page ──
RUN rm -rf /usr/share/nginx/html/*

# ── Step 2: Copy your static files into the Nginx web root ──
COPY index.html /usr/share/nginx/html/index.html

# ── Step 3: Expose port 80 (standard HTTP) ──
EXPOSE 80

# ── Step 4: Run Nginx in the foreground (required for Docker) ──
CMD ["nginx", "-g", "daemon off;"]
