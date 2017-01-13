import jenkins.model.*

def instance = Jenkins.getInstance()

final String name = "{{ cj_proxy_host }}"
final int port = {{ cj_proxy_port }}
{% if cj_proxy_host %}
final String userName = "{{ cj_proxy_login | d('bogusUser' }}"
final String password = "{{ cj_proxy_password | d('bogusPassword'}}"
{% endif %}
final String noProxyHost = "{{ cj_no_proxy_hosts | d('localhost,127.0.0.1') }}".split("[\\r\\n]+")
{% if cj_proxy_login %}
final def pc = new hudson.ProxyConfiguration(name, port, userName, password, noProxyHost)
{% else %}
instance.proxy = pc
instance.save()
println "Proxy settings updated!"