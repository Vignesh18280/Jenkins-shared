def call(String dockerImg_name, String docker_tag, String hub_cred) {
    withCredentials([usernamePassword(
        credentialsId: "${hub_cred}", 
        usernameVariable: "dockerhubUser", 
        passwordVariable: "dockerhubPass"
    )]) {
        sh 'echo $dockerhubPass | docker login -u $dockerhubUser --password-stdin'
        def newTag = "${dockerhubUser}/${dockerImg_name}:${docker_tag}"
        sh "docker image tag ${dockerImg_name}:${docker_tag} ${newTag}"
        sh "docker push ${newTag}"
    }
}
