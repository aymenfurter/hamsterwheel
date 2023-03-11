# Hamsterwheel 

Hamsterwheel is a sample application created to test out [KEDA](https://keda.sh/), specifically around configuring the `coolDown` in KEDA through `stabilizationWindowSeconds`.

Make sure you have the connection string added as a secret to your kubernetes cluster: `kubectl create secret generic servicebus-secret --from-literal=servicebus-connection-string="<YOUR_CONNECTION_STRING>"`