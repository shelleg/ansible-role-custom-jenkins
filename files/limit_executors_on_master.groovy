import jenkins.model.*

def instance = Jenkins.getInstance()

instance.setNumExecutors(1)

instance.save()