def call(String docker_image , String docker_tag){
  sh "docker ps" //checking for docker availability
  echo "Building docker image"
  sh "docker build -t ${docker_image}:${docker_tag}"
  echo "Built successfully"
}
