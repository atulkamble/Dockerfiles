Rails.application.routes.draw do
  get "/",       to: "hello#index"
  get "/health", to: "hello#health"
end
