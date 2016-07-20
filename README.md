# TomatoApp

### Build
```
mvn clean package
```

### Deploy
Run Your Tomcat server and deploy new WAR app located at:
```
./target/TomatoApp.war
```

### Sample output
GET `/data?size=1`
```
[
  {
    "id": "a0ffc6c1-b350-4784-ad65-6fdd1a856aaa",
    "tomatoes": 1340,
    "provider": "Le Ol' Granma",
    "timestamp": 1453194291
  }
]
```

### Sample error
GET `/not-found`
STATUS: 404
```
[]
```