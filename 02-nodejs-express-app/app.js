"use strict";

const express = require("express");
const app = express();
const PORT = process.env.PORT || 3000;

// Root endpoint — returns a greeting
app.get("/", (req, res) => {
  res.send("Hello, Express on Docker!");
});

// Health-check endpoint for container orchestrators
app.get("/health", (req, res) => {
  res.json({ status: "ok" });
});

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
