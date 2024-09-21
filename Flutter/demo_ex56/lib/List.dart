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
          title: Text('ListView Builder Example'),
        ),
        body: ListView.builder(
          itemCount: 10,
          itemBuilder: (BuildContext context, int index) {
            return ListTile(
              leading: const Icon(
                Icons.account_circle,
                size: 40,
              ),
              title: Text(
                "User ${index + 1}",
                style: TextStyle(fontWeight: FontWeight.w600),
              ),
            );
          },
        ),
      ),
    );
  }
}
