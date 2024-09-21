import 'package:demo_ex56/main.dart';
import 'package:flutter/material.dart';

void main(){
  runApp(const MyApp());
  
}

class MyApp extends StatelessWidget{
  const MyApp ({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget{
  const MyHomePage({Key? key, required this.title}) : super (key: key);
  final String title;
  @override
  State<MyHomePage> createState() => _MyHomePageState() ;
  }

class _MyHomePageState extends State<MyHomePage>{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text('Column Demo',
            ),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                const Text('Demo 1',
                ),
                const Text('Demo 2',
                ),
                const Text('Demo 3',
                ),
              ],
            )
          ],
        ),
      ),
    );
  }
}