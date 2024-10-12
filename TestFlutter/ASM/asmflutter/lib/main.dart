import 'package:asmflutter/presentation/home_screen.dart';
import 'package:flutter/material.dart';
import 'package:my_app/presentation/home_screen.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        scaffoldBackgroundColor: Colors.white,
      ),
      home: HomeScreen(),
    );
  }
}