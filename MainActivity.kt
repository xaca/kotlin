class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AcademiaTheme {

                Scaffold(topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = { header(modifier = Modifier) }
                        )
                    }, content = {
                        innerPadding -> Prueba(::abrirSeccion, modifier = Modifier.padding(innerPadding))
                    })

            }
        }
    }

    fun abrirSeccion():Unit
    {
        Toast.makeText(applicationContext,"Test",Toast.LENGTH_LONG).show()
        /*Intent(applicationContext,AcercaDe::class.java).also{
            startActivity(it)
        }*/
    }
}

@Composable
fun header(modifier: Modifier)
{
    Text(text = "Encabezado")
}

@Composable
fun Prueba(onClick:()->Unit, modifier: Modifier = Modifier) {
    var a by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }

    Column(modifier = modifier.background(Color.Cyan).
        padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        TextField(modifier = modifier.fillMaxWidth().background(Color.Red), value = a, onValueChange = {a = it}, label = {Text("Ingrese a")})
        //Spacer(modifier.height(5.dp))
        TextField(modifier = modifier.fillMaxWidth().background(Color.Yellow), value = b, onValueChange = {b = it}, label = {Text("Ingrese b")})
        Button(onClick =onClick){
            Text(text="Siguiente")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AcademiaTheme {
        Prueba(onClick = { Log.d("mensaje","Preview")} )
    }
}
