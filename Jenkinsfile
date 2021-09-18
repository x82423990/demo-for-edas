/* groovylint-disable-next-line NglParseError */
pipeline {
    environment {
        imagename = 'registry.cn-beijing.aliyuncs.com/bzbareg/demo:1.0'
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
                git([url: 'https://github.com/x82423990/demo-for-edas.git', branch: 'master'])
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
//        stage('push Image') {
//            steps {
//                script {
//                    docker.withRegistry(registry, "ecr:eu-central-1:" + registryCredential) {
//                        dockerImage.push()
//                    }
//                }
//            }
//        }
        stage('deploy to EDAS') {
            steps {
                script {
                    edasClient([deployK8sApplication(appId: '4356e997-6b5a-4639-bc5e-647e99142c57', args: '', cpuLimit: '', cpuRequest: '', credentialsString: 'demoEDAS : LTAIDcZDlqTu96Va', edasContainerVersion: '', envs: '', image: true, jdk: '', memoryLimit: '', memoryRequest: '', namespace: 'cn-beijing:default', replicas: '', targetObject: 'registry.cn-beijing.aliyuncs.com/bzbareg/demo:1.0', updateStrategy: '', webContainer: '')])
                }
            }
        }

    }
}