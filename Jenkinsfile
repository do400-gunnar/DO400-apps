node('nodejs') {
	stages {
		stage('checkout') {
			git branch: 'scripted-pipelines', url: 'https://github.com/do400-gunnar/DO400-apps.git'
		}
		stage('backend') {
			sh 'node simple-webapp/backend/test.js'
		}
	}
}