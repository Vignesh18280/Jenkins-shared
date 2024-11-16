def call(String dockerImg_name , String docker_tag , String hub_cred){
  withCredentials[(usernamePassword(
    credentialsId : "${hub_cred}",
     usernameVariable:"dockerhubUser", 
     passwordVariable:"dockerhubPass"
  )]){
   sh 'echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin'
   sh "docker image tag ${dockerImg_name}:${docker_tag} ${env.dockerhubUser}/hello-app:latest"
   sh "docker push ${env.dockerhubUser}/${dockerImg_name}:${docker_tag}"
  }
}
