//
// Configure Tool - Maven
//
// Installs a Maven installation named "maven-3" if one is not already found.
// References:
// * https://github.com/batmat/jez/blob/master/jenkins-master/init_scripts/add_maven_auto_installer.groovy
// * https://wiki.jenkins-ci.org/display/JENKINS/Add+a+Maven+Installation%2C+Tool+Installation%2C+Modify+System+Config
// * https://github.com/glenjamin/jenkins-groovy-examples/blob/master/README.md


// These are the basic imports that Jenkin's interactive script console
// automatically includes.
import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

mavenName = "maven-3"
mavenVersion = "3.3.9"
println("Checking Maven installations...")

// Grab the Maven "task" (which is the plugin handle).
mavenPlugin = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]

// Check for a matching installation.
maven3Install = mavenPlugin.installations.find {
	install -> install.name.equals(mavenName)
}

// If no match was found, add an installation.
if(maven3Install == null) {
	println("No Maven install found. Adding...")

	newMavenInstall = new hudson.tasks.Maven.MavenInstallation('maven-3', null,
		[new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller(mavenVersion)])]
	)

	mavenPlugin.installations += newMavenInstall
	mavenPlugin.save()

	println("Maven install added.")
} else {
	println("Maven install found. Done.")
}