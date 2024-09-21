import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:flutter_34ex/main.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: 'Flutter Demo by Hanh',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Cars'),
    );
  }
}

class MyHomePage extends StatelessWidget{
  const MyHomePage({required this.title, super.key});

  final String title;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title),

      ),
      body: ListView(children: const<Widget>[
        CarWidget('Bmw', 'M3',
        "htpps://media.ed.edmunds-media.com/bmw/m3/2018/oem/2018_bmw_m3_sedan_base_fq_oem_4_150.jpg"),
        CarWidget('Nissan', 'GTR',
        "htpps://media.ed.edmunds-media.com/nissan/gt-r/2018/oem/2018_nissan_gt-r_couple_nismo_fq_oem_1_150.jpg"),
        CarWidget('Nissan', 'Sentra',
        "htpps://media.ed.edmunds-media.com/nissan/sentra/2017/oem/2017_nissan_sentra_sedan_sr-turbo_fq_oem_4_150.jpg"),
      ]),
    );
  }
}

class CarWidget extends StatelessWidget{
  const CarWidget(this.make, this.model, this.imageSrc, {super.key});

  final String make;
  final String model;
  final String imageSrc;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(20.0),
      child: Container(
        decoration: BoxDecoration(border: Border.all()),
        padding: EdgeInsets.all(20.0),
        child: Center(
          child: Column(children: <Widget>[
            Text('${make} ${model}' , style: TextStyle(fontSize: 24.0)),
            Padding(
              padding: EdgeInsets.only(top: 20.0),
              child: Image.network(imageSrc)
            )
          ])
        )
      )
      );
  }
}