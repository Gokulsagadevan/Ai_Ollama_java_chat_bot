# Step 1: Use an OpenJDK image to build and run your Java application
FROM openjdk:11-jdk-slim

# Step 2: Install curl and necessary tools to fetch Ollama
RUN apt-get update && apt-get install -y \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Step 3: Install Ollama using its installation script
RUN curl -sSL https://ollama.com/install.sh | bash

# Step 4: Set the working directory for your Java application
WORKDIR /app

# Step 5: Copy your Java application (JAR file) into the container
COPY target/your-java-app.jar /app/

# Step 6: Expose the port that your Java application will use (usually 8080)
EXPOSE 8080

# Step 7: Run your Java application when the container starts
CMD ["java", "-jar", "/app/your-java-app.jar"]
