import json
from pprint import pprint
import urllib

def le_url(ip, url_site):
    resp = urllib.urlopen("http://" + ip + ":8000" + url_site)
    data = json.loads(resp.read())
    return data
print "Digite o IP do click-on-osv(com os pontos)"
ip = "192.168.122.79" #raw_input()
metrics = le_url(ip, "/click_plugin/metrics")
vnfid = le_url(ip, "/click_plugin/vnf_identification")
start = le_url(ip, "/click_plugin/start")
print metrics

if(le_url(ip, "/click_plugin/running")):
    print metrics["list"][0]["value"] , "\n"
    print metrics["time_ms"]
    print "running"
else:
    print "VNF isn't running."
