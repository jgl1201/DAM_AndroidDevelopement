
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.commoncontextualmenu.Article
import com.example.commoncontextualmenu.ArticleAdapter
import com.example.commoncontextualmenu.GutterDecoration
import com.example.commoncontextualmenu.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.articles_grid)

        val articleList: RecyclerView = findViewById(R.id.grid)

        val articleAdapter = ArticleAdapter { article -> onItemClick(article) }
        val gutter = resources.getDimensionPixelSize(R.dimen.grid_gutter)

        val gridLayoutManager = GridLayoutManager(this@MainActivity, 2)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int) = when (position) {
                0 -> 2
                else -> 1
            }
        }

        articleList.apply {
            adapter = articleAdapter
            layoutManager = gridLayoutManager
            addItemDecoration(GutterDecoration(gutter))
        }

        articleAdapter.submitList(Article.data)
    }

    private fun onItemClick(article: Article) {
        Toast.makeText(this, article.title, Toast.LENGTH_SHORT).show()
    }
}