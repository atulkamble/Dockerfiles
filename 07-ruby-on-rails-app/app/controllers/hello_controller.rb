class HelloController < ApplicationController
  # GET / — returns a JSON greeting
  def index
    render json: { message: "Hello, Rails on Docker!" }
  end

  # GET /health — health-check for container orchestrators
  def health
    render json: { status: "ok" }
  end
end
