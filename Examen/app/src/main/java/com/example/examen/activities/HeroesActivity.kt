package com.example.examen.activities
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.Models.Hero
import com.example.examen.R
import com.example.loginapp.HeroAdapter

class HeroesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        val allHeroesAndVillains = listOf(
            // Héroes de DC
            Hero("https://pbs.twimg.com/media/F2OBK12WAAAXMHj.jpg", "Batman", 2, "Hero"),
            Hero("https://media.tenor.com/pTsbtnohvBEAAAAe/starman-superman.png", "Superman", 2, "Hero"),
            Hero("https://i.chzbgr.com/full/8804798464/h70248E97/funny-comics-superheroes-moment-aquaman-flash-green-lantern", "Linterna Verde", 2, "Hero"),
            Hero("https://photos.costume-works.com/full/wonder_woman66.jpg", "Wonderwoman", 2, "Hero"),
            Hero("https://m.media-amazon.com/images/I/61dxHxlT+wL._AC_UF350,350_QL80_.jpg", "AquaMan", 2, "Hero"),

            // Villanos de DC
            Hero("https://i.pinimg.com/474x/cb/c0/a0/cbc0a0892a621694a5795db3fecbac44.jpg", "Joker", 2, "Villain"),
            Hero("https://media.tenor.com/EtPiTQ2x1I8AAAAe/luthor-lex.png", "Lex Luthor", 2, "Villain"),
            Hero("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSadhTcTEIYwQZSshvTjaeMtC_-Oj2ycWKsDw&s", "Sr.Frio", 2, "Villain"),
            Hero("https://i.pinimg.com/474x/6e/26/f9/6e26f946f1f109cec05cb82d8217de82.jpg", "Darkseid", 2, "Villain"),
            Hero("https://static.wikia.nocookie.net/doblaje/images/9/99/Manta-raya.png/revision/latest?cb=20140709184700&path-prefix=es", "Black Manta", 2, "Villain"),

            // Héroes de Marvel
            Hero("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNC_LHXt2SAP4ZPN4ZXNj9kqSUSLE9YkO1rA&s", "Spider-Man", 1, "Hero"),
            Hero("https://i.pinimg.com/736x/cd/15/56/cd1556f37ef93d642ea3d572f8b9a276.jpg", "Iron Man", 1, "Hero"),
            Hero("https://static1.cbrimages.com/wordpress/wp-content/uploads/2021/11/Skinny-hulk-smiling-creepily.jpg", "Hulk", 1, "Hero"),
            Hero("https://static1.srcdn.com/wordpress/wp-content/uploads/2022/06/Love-and-Thunder-Naked-Thor-Scene.jpg", "Thor", 1, "Hero"),
            Hero("https://qph.cf2.quoracdn.net/main-qimg-7d9ddf5653a767b5ce2a5688d1a707b0-lq", "Viuda Negra", 1, "Hero"),



            // Villanos de Marvel
            Hero("https://static.wikia.nocookie.net/mokeys-show/images/5/59/Manos.png/revision/latest/thumbnail/width/360/height/360?cb=20230102140308", "Thanos", 1, "Villain"),
            Hero("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfP6ysVizY-mklhwstyq_d9vbuasqpC3GB9x_5eNq-a8HW-Km5D7WzSa0Tcw5-NCI9LlA&usqp=CAU", "Green Goblin", 1, "Villain"),
            Hero("https://pbs.twimg.com/media/FpESjClX0AAhTgH?format=jpg&name=small", "Modok", 1, "Villain"),
            Hero("https://i.ytimg.com/vi/VUwY8fzZuQI/maxresdefault.jpg?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AHUBoAC4AOKAgwIABABGGYgZihmMA8=&rs=AOn4CLDy_s8Yvm3McMAlCpo2naIIKRQ2EQ", "Venom", 1, "Villain"),
            Hero("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfP6ysVizY-mklhwstyq_d9vbuasqpC3GB9x_5eNq-a8HW-Km5D7WzSa0Tcw5-NCI9LlA&usqp=CAU", "Green Goblin", 1, "Villain"),
        )

        // Configurar las listas
        setupRecyclerView(findViewById(R.id.dc_heroes_list), allHeroesAndVillains.filter { hero ->
            hero.PublisherId == 2 && hero.type == "Hero"
        })
        setupRecyclerView(findViewById(R.id.dc_villains_list), allHeroesAndVillains.filter { villain ->
            villain.PublisherId == 2 && villain.type == "Villain"
        })
        setupRecyclerView(findViewById(R.id.marvel_heroes_list), allHeroesAndVillains.filter { hero ->
            hero.PublisherId == 1 && hero.type == "Hero"
        })
        setupRecyclerView(findViewById(R.id.marvel_villains_list), allHeroesAndVillains.filter { villain ->
            villain.PublisherId == 1 && villain.type == "Villain"
        })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, data: List<Hero>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = HeroAdapter(data) { hero ->
            // Navegar a HeroDetailActivity con los datos del héroe
            val intent = Intent(this, HeroDetailActivity::class.java).apply {
                putExtra("heroName", hero.name)
                putExtra("heroImageUrl", hero.imageUrl)
                putExtra("heroPublisherId", hero.PublisherId)
                putExtra("heroType", hero.type)
            }
            startActivity(intent)
        }
    }
}
