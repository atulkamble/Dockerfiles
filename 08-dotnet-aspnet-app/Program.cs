var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

// Root endpoint — returns a greeting
app.MapGet("/", () => "Hello, from ASP.NET App!");

// Health-check endpoint for container orchestrators
app.MapGet("/health", () => Results.Ok(new { status = "ok" }));

app.Run();
