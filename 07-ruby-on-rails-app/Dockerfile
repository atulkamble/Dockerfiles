# =============================================================
# Ruby on Rails Application (API mode)
# Base image: ruby:3.4-slim (latest stable, minimal footprint)
# =============================================================
FROM ruby:3.4-slim

# ── Step 1: Install system dependencies required by native gems ──
RUN apt-get update -qq && \
  apt-get install -y --no-install-recommends \
  build-essential \
  libsqlite3-dev && \
  rm -rf /var/lib/apt/lists/*

# ── Step 2: Set the working directory inside the container ──
WORKDIR /app

# ── Step 3: Copy Gemfile and install gems (cached layer) ──
COPY Gemfile ./
RUN bundle install --jobs 4 --retry 3

# ── Step 4: Copy the rest of the application source code ──
COPY . .

# ── Step 5: Expose the port Puma listens on ──
EXPOSE 3000

# ── Step 6: Start the Rails server bound to all interfaces ──
CMD ["bundle", "exec", "rails", "server", "-b", "0.0.0.0"]
