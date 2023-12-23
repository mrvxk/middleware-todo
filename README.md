# middleware-todo

[![Quarkus Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-service.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-service.yml)
[![Quarkus Native Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service.yml)
[![Quarkus Native Silicon Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service-silicon.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-native-service-silicon.yml)
[![UI Docker Image Build](https://github.com/mrvxk/middleware-todo/actions/workflows/build-ui.yml/badge.svg)](https://github.com/mrvxk/middleware-todo/actions/workflows/build-ui.yml)

### Start dev mode

Type in `todo-service`:
> quarkus dev

Type in `todo-ui`:
> yarn dev

## Tech Stack

### Why Quarkus?

I'd like to explain my decision to use Quarkus, particularly in light of the project's requirements to align with the
12-factor app principles. The 12-factor app methodology is essential for developing scalable and maintainable
applications, especially in modern cloud environments. It emphasizes factors like codebase, dependencies, configuration,
backing services, and more, each critical for a robust application.

Quarkus emerged as an ideal solution for this project due to its alignment with these principles. Its lightweight,
Kubernetes-native Java framework is particularly suited for cloud environments, offering rapid startup times and low
memory footprint. This is crucial for this project, which not only needs to comply with the theoretical aspects of the
12-factor app but also demonstrate practical efficiency in a scalable Kubernetes environment. The fast startup times are
particularly beneficial for rapidly scaling services, a key aspect of cloud-native applications and a vital requirement
for this project.

### CI/CD

Within this project, GitHub Actions are employed to automate the build and deployment processes. Utilizing these
actions, various images are constructed and subsequently made publicly available on the GitHub Container Registry.
Specifically, the setup includes four distinct workflow files, each dedicated to creating different artifacts - the UI,
a backend with JVM, and native builds for both arm64/amd64, along with a native build on a MacOS runner.

The MacOS runner proves to be essential because the native arm64 image does not operate as expected. However, even the
image optimized and built on MacOS does not run on Apple Silicon Macs, due to its reliance on amd64 architecture instead
of arm.

Consequently, the image found in the registry has been locally built and pushed on an M1 Mac. If a Github runner with
Apple Silicon were utilized, the pipeline would be operational in that context as well. However, setting up such a
runner exceeds the requirements for this proof of concept, and I am currently satisfied with the outcomes achieved.

## Run the application

### Docker Compose

### Configuration

For the backend service, port 8080 is the default within the container. To make this service available outside
the container, you can configure Docker to expose this port to an external port of your choosing. This is done through
Docker's configuration, where you link the internal port `8080` to an external port.

If you need to change the internal port of the backend service from `8080` to a different one, this can be accomplished
using an environment variable. In our setup, the `HTTP_PORT` environment variable is used for this purpose. By setting
`HTTP_PORT` to the desired port number, you instruct the backend service to listen on this new port inside the container.

For the user interface component, which is served by `Nginx`, the default port used inside the container is `80`. To
access this UI externally, you would also configure Docker to expose this internal port to an external port. The choice
of the external port is flexible, allowing you to select a port that fits your network configuration and avoids
conflicts with other services.

