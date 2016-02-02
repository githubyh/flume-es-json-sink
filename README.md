# flume-es-json-sink  （支持批量）



通过ElasticSearchLog4jEventSerializer 解析log4j日志批量推送至es

flume-es.properties sink1配置：
#ElasticsearchSink使用com.yh.flume.sink.elasticsearch.com.yh.flume.sink.elasticsearch.ElasticSearchLog4jEventSerializer解析log4j日志信息。
agent1.sinks.sink1.type = org.apache.flume.sink.elasticsearch.ElasticSearchSink
agent1.sinks.sink1.batchSize = 500
agent1.sinks.sink1.hostNames = 192.168.56.100:9300
agent1.sinks.sink1.indexName = yh-test
agent1.sinks.sink1.indexType = yh-yyyy-MM-dd
agent1.sinks.sink1.clusterName = elasticsearch
agent1.sinks.sink1.serializer=com.yh.flume.sink.elasticsearch.ElasticSearchLog4jEventSerializer
agent1.sinks.sink1.serializer.fields=user_id event_type log_type log_source log_body level timestamp remote_addr request_body response_body time_consuming request_uri status
agent1.sinks.sink1.ttl=1
#agent1.sinks.sink1.indexNameBuilder=org.apache.flume.sink.elasticsearch.SimpleIndexNameBuilder
agent1.sinks.sink1.indexNameBuilder=org.apache.flume.sink.elasticsearch.TimeBasedIndexNameBuilder
@注释#这里指定每个月一个index， flume-ng-elasticsearch-sink 源码加载dataFormat有个bug，已提交至官方jira
agent1.sinks.sink1.indexNameBuilder.dateFormat=yyyy-MM

#agent1.sinks.sink1.serializer.fields.status.serializer=int
#agent1.sinks.sink1.serializer.fields.time_local.serializer=date
#agent1.sinks.sink1.serializer.fields.time_local.format=yyyy-MM-dd HH:mm:ss
#agent1.sinks.sink1.serializer.fields.time_local.locale=en


以下包上传至flume_home/lib下
flume-ng-elasticsearch-sink-1.6.0.jar
flume-es-json-sink.jar 
elasticsearch-1.6.0.jar
lucene*相关依赖jar
