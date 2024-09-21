import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Table Example'),
        ),
        body: 
        Table(
          children: [
            TableRow(
              children: [
                Text("Name", textScaleFactor: 1.5, style: TextStyle(fontWeight: FontWeight.w600),),
                Text("Subject", textScaleFactor: 1.5, style: TextStyle(fontWeight: FontWeight.w600),),
                Text("Marks", textScaleFactor: 1.5, style: TextStyle(fontWeight: FontWeight.w600),),
              ]
            ),
            TableRow(
              children: [
                Text("Alex", textScaleFactor: 1.5),
                Text("Maths", textScaleFactor: 1.5),
                Text("98", textScaleFactor: 1.5),
              ]
            ),
            TableRow(
              children: [
                Text("Henry", textScaleFactor: 1.5),
                Text("Chemistry", textScaleFactor: 1.5),
                Text("35", textScaleFactor: 1.5),
              ]
            ),
            TableRow(
              children: [
                Text("Luke", textScaleFactor: 1.5),
                Text("Physics", textScaleFactor: 1.5),
                Text("40", textScaleFactor: 1.5),
              ]
            ),
          ],
        ),
      ),
    );
  }
}
