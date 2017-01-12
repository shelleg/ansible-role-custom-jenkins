import jenkins.model.*

def instance = Jenkins.getInstance()

final String name = "{{ jenkins_proxy_host }}"
final int port = {{ jenkins_proxy_port }}
{% if jenkins_proxy_host %}
final String userName = "{{ jenkins_proxy_login | d('bogusUser' }}"
final String password = "{{ jenkins_proxy_password | d('bogusPassword'}}"
{% endif %}
final String noProxyHost = "{{ jenkins_no_proxy_hosts | d('localhost,127.0.0.1') }}".split("[\\r\\n]+")
{% if jenkins_proxy_login %}
final def pc = new hudson.ProxyConfiguration(name, port, userName, password, noProxyHost)
{% else %}
instance.proxy = pc
instance.save()
println "Proxy settings updated!"