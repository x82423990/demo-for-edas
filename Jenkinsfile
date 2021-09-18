/* groovylint-disable-next-line NglParseError */
pipeline {
    environment {
        imagename = 'aliyun/hacicenkins'
        registryCredential = 'yenigul-dockerhub'
        mvnHome = '/usr/local/apache-maven-3.8.2/bin'
    }
  agent {
    node {
      label 'master'
    }
  }
    stages {
        stage('Cloning Git') {
            steps {
                git([url: 'https://github.com/x82423990/demo.git', branch: 'master'])
            }
        }
        stage('mvn build') {
            steps {
                sh '${mvnHome}/mvn -B -DskipTests clean package'
            }
        }
        stage('build image') {

            steps {
                    sh 'echo $hostname'
                    sh 'docker build -t test .'
            }
        }
        stage('push Image') {
            steps {
                script{
                docker.withRegistry("https://" + registry, "ecr:eu-central-1:" + registryCredential) {
                    dockerImage.push()
                }
                }
            }
        }
        stage('deploy to EDAS'){
            steps{
                edasClient([deployK8sApplication(appId: '4356e997-6b5a-4639-bc5e-647e99142c57', args: '', cpuLimit: '', cpuRequest: '', credentialsString: 'demoEDAS : LTAIDcZDlqTu96Va', edasContainerVersion: '', envs: '', image: true, jdk: '', memoryLimit: '', memoryRequest: '', namespace: 'cn-beijing:default', replicas: '', targetObject: ' registry.cn-beijing.aliyuncs.com/bzbareg/demo:3.0', updateStrategy: '', webContainer: '')])
            }
        }

    }
}