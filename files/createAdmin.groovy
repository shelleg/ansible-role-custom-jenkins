import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("MyUSERNAME","MyPASSWORD")
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER, "myUSERNAME")
instance.setAuthorizationStrategy(strategy)

instance.save()
