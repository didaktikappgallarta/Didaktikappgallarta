package com.example.didaktikapp;

import android.util.Log;

import com.example.didaktikapp.model.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DataHelper {
    static final int N = -1;
    static final int L = 0;
    static final int T = 1;
    static final int R = 2;
    static final int B = 3;
    private static final String TAG = DataHelper.class.getSimpleName();

    private int squareRootNum;
    private List<Block> models;

    DataHelper(){
        models = new ArrayList<>();
    }

    private void reset() {
        models.clear();
        int position = 0;
        for (int i = 0; i< squareRootNum; i++){
            for (int j = 0; j < squareRootNum; j++){
                models.add(new Block(position, i, j));
                position ++;
            }
        }
    }

    void setSquareRootNum(int squareRootNum){
        this.squareRootNum = squareRootNum;
        reset();
    }

    boolean swapValueWithInvisibleModel(int index){
        Block formModel = models.get(index);
        Block invisibleModel = models.get(0);
        swapValue(formModel, invisibleModel);
        return isCompleted();
    }

    /**
     * metodo para cambiar el valor de la pieza cuando se mueve
     * @param model
     * @param invisibleModel
     */
    private void swapValue(Block model, Block invisibleModel) {

        int position = model.position;
        int hPosition = model.hPosition;
        int vPosition = model.vPosition;

        model.position = invisibleModel.position;
        model.hPosition = invisibleModel.hPosition;
        model.vPosition = invisibleModel.vPosition;

        invisibleModel.position = position;
        invisibleModel.hPosition = hPosition;
        invisibleModel.vPosition = vPosition;
    }

    /**
     * metodo para cuando se termina el puzzle
     */
    private boolean isCompleted(){
        int num = squareRootNum * squareRootNum;
        for (int i = 0; i < num; i++){
            Block model = models.get(i);
            if(model.position != i){
                return false;
            }
        }
        return true;
    }

    public Block getModel(int index){
        return models.get(index);
    }

    /**
     * metodo para coger la posicion de la pieza
     * @param currentPosition
     * @return i
     */
    private int getIndexByCurrentPosition(int currentPosition){
        int num = squareRootNum * squareRootNum;
        for (int i = 0; i < num; i++) {
            if(models.get(i).position == currentPosition)
                return i;
        }
        return -1;
    }

    /**
     * metodo para saber que piezas estan pegando a la pieza que se quiere mover
     */
    public int findNeighborIndexOfInvisibleModel() {
        Block invisibleModel = models.get(0);
        int position = invisibleModel.position;
        int x = position % squareRootNum;
        int y = position / squareRootNum;
        int direction = new Random(System.nanoTime()).nextInt(4);
        Log.d(TAG, "direction " + direction);
        switch (direction){
            case L:
                if(x != 0)
                    return getIndexByCurrentPosition(position - 1);
            case T:
                if(y != 0)
                    return getIndexByCurrentPosition(position - squareRootNum);
            case R:
                if(x != squareRootNum - 1)
                    return getIndexByCurrentPosition(position + 1);
            case B:
                if(y != squareRootNum - 1)
                    return getIndexByCurrentPosition(position + squareRootNum);
        }
        return findNeighborIndexOfInvisibleModel();
    }

    /**
     * metodo para coger la direccion en la que se quiere mover la pieza
     * @param index
     */
    int getScrollDirection(int index){

        Block model = models.get(index);
        int position = model.position;

        int x = position % squareRootNum;
        int y = position / squareRootNum;
        int invisibleModelPosition = models.get(0).position;

        if(x != 0 && invisibleModelPosition == position - 1)
            return L;

        if(x != squareRootNum - 1 && invisibleModelPosition == position + 1)
            return R;

        if(y != 0 && invisibleModelPosition == position - squareRootNum)
            return T;

        if(y != squareRootNum - 1 && invisibleModelPosition == position + squareRootNum)
            return B;

        return N;
    }
}
