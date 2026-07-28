//==============================================
// Ejercicio 2

// Contador de clicks

// Importar librerias
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Font
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.SwingConstants
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

// Clase principal que hereda los componentes de ventana (JFrame)
class ContadorClicks : JFrame() {
    // Creo una variable donde guardaremos la cantidad de clicks
    private var contador = 0

    // Colocar una etiqueta en el frame para mostrar contador
    private val lblContador = JLabel("Clicks: 0", SwingConstants.CENTER)
    private val btnClick = JButton("Haz Click")
    private val btnReiniciar = JButton("Reiniciar")

    init {
        // Titulo
        title = "Contador Nuevo $contador"

        // Tamano ventana
        setSize(400, 250)

        // Centrar la pantalla
        setLocationRelativeTo(null)

        // Cerrar todo el programa
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        // Crear espacio entre componentes
        layout = BorderLayout(10, 10)

        // Estilos del texto del contador
        lblContador.font = Font("Verdana", Font.BOLD, 30)

        // Estilo boton del click
        btnClick.font = Font("Verdana", Font.PLAIN, 20)

        btnClick.addActionListener {
            contador++
            actualizarContador()

            if (contador == 50) {
                JOptionPane.showMessageDialog(
                    this,
                    "Llegaste a 50 clicks",
                    "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE
                )
            }
        }

        // Estilo boton de reiniciar
        btnReiniciar.font = Font("Verdana", Font.BOLD, 15)
        btnReiniciar.addActionListener {
            contador = 0
            lblContador.text = "Click: 0"
            title = "Contador Nuevo $contador"
            lblContador.foreground = Color.MAGENTA
        }

        // Creamos panel para colocar los botones
        val panelInferior = JPanel()
        panelInferior.add(btnClick)
        panelInferior.add(btnReiniciar)

        // Agregar elementos a la ventana
        add(lblContador, BorderLayout.CENTER)
        add(panelInferior, BorderLayout.SOUTH)
        isVisible = true
    }

    private fun actualizarContador() {
        lblContador.text = "Clicks: $contador"
        title = "Contador Nuevo $contador"
        lblContador.foreground = if (contador >= 10) Color.GREEN else Color.BLACK
    }
}

fun main() {
    SwingUtilities.invokeLater {
        ContadorClicks()
    }
}
