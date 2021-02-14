# Setting up istio
# Specify the Istio version that will be leveraged throughout these instructions
ISTIO_VERSION=1.7.3

curl -sL "https://github.com/istio/istio/releases/download/$ISTIO_VERSION/istioctl-$ISTIO_VERSION-linux-amd64.tar.gz" | tar xz


gcloud container clusters get-credentials standard-cluster-1 --zone=europe-west1-b
kubectl create namespace istio-system
curl -L https://git.io/getLatestIstio | ISTIO_VERSION=1.2.2 sh -
cd istio-1.2.2
for i in install/kubernetes/helm/istio-init/files/crd*yaml; do kubectl apply -f $i; done
helm template install/kubernetes/helm/istio --name istio --set global.mtls.enabled=false --set tracing.enabled=true --set kiali.enabled=true --set grafana.enabled=true --namespace istio-system > istio.yaml
kubectl apply -f istio.yaml

kubectl label namespace default istio-injection=enabled
```

Windows - https://curl.haxx.se/windows/

# Using Kiali

- http://localhost:20001

```
kubectl port-forward \
    $(kubectl get pod -n istio-system -l app=kiali \
    -o jsonpath='{.items[0].metadata.name}') \
    -n istio-system 20001
```
Create a secret
```
kubectl get secret -n istio-system kiali
kubectl create secret generic kiali -n istio-system --from-literal=username=admin --from-literal=passphrase=admin
```

# Using Graphana to see prometheus metrics
- http://localhost:3000

```
kubectl -n istio-system port-forward \
    $(kubectl -n istio-system get pod -l app=grafana \
    -o jsonpath='{.items[0].metadata.name}') 3000
```

# Using Jaeger

http://localhost:16686

```
kubectl port-forward -n istio-system \
    $(kubectl get pod -n istio-system -l app=jaeger \
    -o jsonpath='{.items[0].metadata.name}') 16686
```
