package de.morrox.fontinator;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.AutoCompleteTextView;

import de.morrox.fontinator.utilities.TypefaceLoader;
import de.morrox.fontinator.utilities.Typefaceable;

public class FontAutoCompleteTextView extends AutoCompleteTextView implements Typefaceable {
    private TypefaceLoader typefaceLoader;
    public FontAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        typefaceLoader = TypefaceLoader.get(this, context, attrs);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        Pair<CharSequence, BufferType> pair = TypefaceLoader.inject(typefaceLoader, text, type);
        super.setText(pair.first, pair.second);
    }
}
