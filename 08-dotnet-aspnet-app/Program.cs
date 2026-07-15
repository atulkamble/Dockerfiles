var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

// Root endpoint — returns a greeting
app.MapGet("/", () => "Hello, ASP.NET Core on Docker!");

// Health-check endpoint for container orchestrators
app.MapGet("/health", () => Results.Ok(new { status = "ok" }));

app.Run();
