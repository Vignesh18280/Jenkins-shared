def call(String gitUrl , String gitBranch){
  echo "Cloning the Code"
  git url : "${gitUrl}" , branch : "${gitBranch}"
  echo "Cloned the Code successfully"
}
