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
          title: Text('Grid Example'),
        ),
        body: 
        GridView.builder(
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2,
            mainAxisSpacing: 10,
            crossAxisSpacing: 10),
            itemCount: 5,
            itemBuilder: (BuildContext context,
            int index
            ){
              return Card(
                color: Colors.blueGrey,
                child: Center(
                  child: Text('User ${index+1}',
                  style: TextStyle(
                    fontWeight: FontWeight.w700,
                    fontSize: 25,
                    color: Colors.white
                  ),),
                ),
              );
            }
            
          )
      ),
    );
  }
}
